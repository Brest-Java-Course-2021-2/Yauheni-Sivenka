package com.epam.brest.model;

public class ExitState implements Status{
    @Override
    public Status handle() {
        return null;
    }

    @Override
    public StatusType getType() {
        return StatusType.EXIT;
    }
}
