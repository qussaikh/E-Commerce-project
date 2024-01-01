package com.qussai.security.webService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    // Entity class representing a Movie in the system.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private int rating;

    @Column(name = "description")
    private String description;

    // Timestamp indicating the creation date of the movie.
    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;


    // User ID of the creator of the movie.
    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

}
