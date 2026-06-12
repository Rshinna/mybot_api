package com.rshinna.mybot_api.handler;

public abstract class Handler {

  protected Handler next;

  public void setNext(Handler next) {
    this.next = next;
  }

  public abstract String handle(String mensagem);
}
