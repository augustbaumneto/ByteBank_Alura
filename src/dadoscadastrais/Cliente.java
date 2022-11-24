/**
 *   Classe para guardar os dados do cliente
 */
package dadoscadastrais;

/**
 * @author August Neto
 *
 */
public class Cliente {

	private String nome;
	private String profissao;
	private String cpf;
	
	/**
	 * Construtor padrão
	 * @param nome o nome do cliente
	 * @param profissao a profissão do cliente
	 * @param cpf o cpf do cliente
	 */
	public Cliente(String nome, String profissao, String cpf) {
		this.cpf=cpf;
		this.profissao=profissao;
		this.nome=nome;
	}

	/**
	 * @return nome o nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome o nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return profissao a profissão do cliente
	 */
	public String getProfissao() {
		return profissao;
	}

	/**
	 * @param profissao a profissão do cliente
	 */
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	/**
	 * @return cpf o cpf do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf o cpf do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
