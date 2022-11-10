package com.springframework.studentrecordapi.service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.springframework.studentrecordapi.web.model.ClassDetails;
import com.springframework.studentrecordapi.web.model.StudentBean;

import lombok.NonNull;

@Service
public class StudentServiceImpl implements StudentService {
    private final String COLLECTION_NAME = "students";

    private StudentBean student;
    private List<StudentBean> students = new LinkedList<StudentBean>();

    private Firestore db = FirestoreClient.getFirestore();

    @Override
    public StudentBean getStudentByOid(@NonNull String oid) throws InterruptedException, ExecutionException {
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(oid);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        if (document.exists()) {
            student = document.toObject(StudentBean.class);
        }
        return student;
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
