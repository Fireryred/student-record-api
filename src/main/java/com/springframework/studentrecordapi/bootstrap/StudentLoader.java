package com.springframework.studentrecordapi.bootstrap;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentLoader implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final String COLLECTION_NAME = "students";

    @Override
    public void run(String... args) throws Exception, InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> docs = future.get().getDocuments();

        for (QueryDocumentSnapshot doc : docs) {
            studentRepository.save(doc.toObject(Student.class));
        }
    }

}
