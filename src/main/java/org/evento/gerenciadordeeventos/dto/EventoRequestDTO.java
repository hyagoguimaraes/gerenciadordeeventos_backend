package org.evento.gerenciadordeeventos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EventoRequestDTO {
	
	@NotBlank(message = "Nome é obrigatório")
	public String nome;
	
	@NotNull(message = "Data é obrigatória")
	public LocalDate data;
	
	@NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
	public String cep;
	
	@NotBlank(message = "Logradouro é obrigatório")
	public String logradouro;
	
	@NotBlank(message = "Número é obrigatório")
	public String numero;
	
	@NotBlank(message = "Bairro é obrigatório")
	public String bairro;
	
	@NotBlank(message = "Cidade é obrigatória")
	public String cidade;
	
	@NotBlank(message = "UF é obrigatória")
	public String uf;
	
	@NotBlank(message = "A imagem é obrigatória")
	public String imagem;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
