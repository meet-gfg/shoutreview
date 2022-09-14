package com.gfg.shoutreview.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="review_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String movieReview;

    private double rating;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn
    private Movie movie; // it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

}
