package com.pelican.core.event;

import lombok.ToString;

@ToString
public class DeletedEvent {
  protected boolean entityFound = true;

  public boolean isEntityFound() {
    return entityFound;
  }
}
