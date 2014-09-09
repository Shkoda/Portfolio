package com.pelican.core.event;

import lombok.ToString;

@ToString
public class ReadEvent {
  protected boolean entityFound = true;

  public boolean isEntityFound() {
    return entityFound;
  }
}
