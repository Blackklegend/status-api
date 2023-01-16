package com.ottimizza.status.Model;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Body {
  String servidor, workflow, contabilidade, empresa, tipo, id;
  LocalDateTime data;

  public Body() {
  }

  public Body(Body autoGenBody) {
    this.servidor = autoGenBody.servidor;
    this.workflow = autoGenBody.workflow;
    this.contabilidade = autoGenBody.contabilidade;
    this.empresa = autoGenBody.empresa;
    this.tipo = autoGenBody.tipo;
    this.data = LocalDateTime.now(ZoneId.of("Brazil/East")); 
    this.id = autoGenBody.servidor + "-" + autoGenBody.workflow;
  }

  public Body(String servidor, String workflow, String contabilidade, String empresa, String tipo, LocalDateTime data) {
    this.servidor = servidor;
    this.workflow = workflow;
    this.contabilidade = contabilidade;
    this.empresa = empresa;
    this.tipo = tipo;
    this.data = data;
    this.id = servidor + "-" + workflow;
  }

  public Body(String servidor, String workflow, String contabilidade, String empresa, String tipo, String id) {
    this.servidor = servidor;
    this.workflow = workflow;
    this.contabilidade = contabilidade;
    this.empresa = empresa;
    this.tipo = tipo;
    this.data = LocalDateTime.now(ZoneId.of("Brazil/East")); 
    this.id = id;
  }

  public Body(String servidor, String workflow, String contabilidade, String empresa, String tipo) {
    this.servidor = servidor;
    this.workflow = workflow;
    this.contabilidade = contabilidade;
    this.empresa = empresa;
    this.tipo = tipo;
    this.data = LocalDateTime.now(ZoneId.of("Brazil/East")); 
    this.id = servidor + "-" + workflow;
  }
  
  public String getServidor() {
    return this.servidor;
  }

  public void setServidor(String servidor) {
    this.servidor = servidor;
  }

  public String getWorkflow() {
    return this.workflow;
  }

  public void setWorkflow(String workflow) {
    this.workflow = workflow;
  }

  public String getContabilidade() {
    return this.contabilidade;
  }

  public void setContabilidade(String contabilidade) {
    this.contabilidade = contabilidade;
  }

  public String getEmpresa() {
    return this.empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getData() {
    DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
    return this.data.format(df);
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "{" +
        " \"servidor\":\"" + getServidor() + "\"" +
        ", \"workflow\":\"" + getWorkflow() + "\"" +
        ", \"contabilidade\":\"" + getContabilidade() + "\"" +
        ", \"empresa\":\"" + getEmpresa() + "\"" +
        ", \"tipo\":\"" + getTipo() + "\"" +
        ", \"data\":\"" + getData() + "\"" +
        "}";
  }
}
