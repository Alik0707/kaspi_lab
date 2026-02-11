package com.example.taskm.entity;

import java.time.LocalDateTime;

import com.example.taskm.enums.Status;
import com.example.taskm.enums.Priority;

public record Task (
    Long id,
    Long creator_id,
    Long assignedUserId,
    Status status,
    LocalDateTime start,
    LocalDateTime end,
    Priority priorety
)
{};