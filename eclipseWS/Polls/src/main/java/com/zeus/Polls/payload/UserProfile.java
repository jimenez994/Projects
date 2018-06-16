package com.zeus.Polls.payload;

import java.time.Instant;

import lombok.Data;

@Data
public class UserProfile {

    private Long id;
    private String username;
    private String name;
    private Instant joinedAt;
    private Long pollCount;
    private Long voteCount;

    public UserProfile(Long id, String username, String name, Instant joinedAt, Long pollCount, Long voteCount) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.joinedAt = joinedAt;
        this.pollCount = pollCount;
        this.voteCount = voteCount;
    }
}
