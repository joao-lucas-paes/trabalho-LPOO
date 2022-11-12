package model;

public interface Verificavel {
    /**
     * @apiNote Este metodo devera validar o CPF para Pessoa, sempre que o CPF for cadastrado ou alterado. Se o valor retronado for false, entao devera chamar o metodo que solicita um novo valor a ser validado.
     * @param codigo codigo a ser validado
     * @return retorna o resultado da validacao
     */
    boolean validar(String codigo);

    /**
     * @apiNote Este metodo devera solicitar um novo CPF para Pessoa, sempre que o valor validado retorna false. Quando o novo valor for fornecido, devera chamar o metodo validar, para que seja verificado novamente.
     */
    void solicitarNovo();
}
