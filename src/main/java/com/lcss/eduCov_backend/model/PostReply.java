package com.lcss.eduCov_backend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PostReply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyId;

    private String replyText;

}
