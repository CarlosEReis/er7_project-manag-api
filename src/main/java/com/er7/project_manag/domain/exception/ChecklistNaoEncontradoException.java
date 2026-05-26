package com.er7.project_manag.domain.exception;

public class ChecklistNaoEncontradoException extends RuntimeException {

    public ChecklistNaoEncontradoException(Long id) {
        super("Checklist com ID " + id + " não encontrado.");
    }
}
