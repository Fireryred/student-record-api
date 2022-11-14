package com.springframework.studentrecordapi.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.repository.StudentRepository;
import com.springframework.studentrecordapi.web.mappers.StudentMapper;
import com.springframework.studentrecordapi.web.model.ClassDetails;
import com.springframework.studentrecordapi.web.model.StudentBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final String COLLECTION_NAME = "students";
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private StudentBean student;
    private List<StudentBean> students = new LinkedList<StudentBean>();

    private Firestore db = FirestoreClient.getFirestore();

    @Override
    public List<StudentBean> getStudents() {
        Iterator<Student> st = studentRepository.findAll().iterator();
        while (st.hasNext()) {
            student = studentMapper.studentToStudentBean(st.next());
            students.add(student);
        }
        return students;
    }

    @Override
    public StudentBean getStudentById(String studentId) throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).whereEqualTo("student_id", studentId).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            student = document.toObject(StudentBean.class);
        }

        return student;
    }

    @Override
    public List<StudentBean> getStudentBySubjectCode(String subjectCode)
            throws InterruptedException, ExecutionException {
        // cannot query for an array of maps, needs to be a reference or something
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            // current loop of the student's data
            student = document.toObject(StudentBean.class);
            if (hasSubjectCode(student, subjectCode))
                students.add(student);
        }
        return students;

    }

    private boolean hasSubjectCode(StudentBean student, String subjectCode) {
        boolean result = false;
        for (ClassDetails dt : student.getClass_details()) {
            if (dt.getSubject_code().equals(subjectCode)) {
                result = true;
            }
        }
        return result;
    }
}
