package com.example.demo.entity;


import jakarta.persistence.*;

    @Entity
    public class Affectation {

        @Id
        // Permet de définir la statégie de génération
        // de la clé lors d'une insertion en base de données.
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }