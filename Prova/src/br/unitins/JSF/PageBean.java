package br.unitins.JSF;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean {

	private String nome;

	public String processar() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("nomeDoUsuario", nome);
		
		return "result?faces-redirect=true";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	 
}
