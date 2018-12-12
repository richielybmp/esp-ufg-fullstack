import React, { Component } from "react";

// Importamos a interface que define o objeto Pessoa.
import IPessoa from "./IPessoa";

// Importamos os componentes utlizados na composição do App.
import Form from "./Form";
import Table from "./Table";

// Interface que define o 'state' do Componente App
interface AppState {
    pessoas: IPessoa[];
}

// Componente App
class App extends Component<{}, AppState> {
    // Construtor do componente, define o valor inicial do seu 'state'.
    // Com o valor inicial, a 1a. renderização já irá possuir os valores definidos.
    // Nesse caso, o 'state' define os itens que estão carregados no componente 'Table'.
    constructor(props: {}) {
        super(props);

        this.state = {
            pessoas: []
            //pessoas: [{ 'nome': 'richiely', 'profissao': 'desenvolvedor' }]
        };
    }

    // Método responsável por excluir um registro da Table. 
    // É repassado para o componente 'Table' que, ao renderizar, 
    // define a ação do botão 'Excluir'. 
    removerPessoa = (index: number) => {
        const { pessoas } = this.state;

        // Atualizando o 'state'
        // Retorna todos os objetos do 'state' menos o objeto do index
        // passado para exclusão.
        this.setState({
            pessoas: pessoas.filter((pessoa, i) => {
                return i !== index; 
            })
        });
    }

    // Método responsável por tratar a ação de enviar um registro 'Pessoa'.
    handleSubmit = (pessoa: IPessoa) => {
        // Adicionamos o novo objeto pessoa ao objeto existente no 'state'.
        this.setState({
            pessoas: [...this.state.pessoas, pessoa]
        })
    }

    render() {
        const { pessoas } = this.state;

        return (
            <div className="container">
                <Form handleSubmit={this.handleSubmit} />
                <Table
                    pessoas={pessoas}
                    removerPessoa={this.removerPessoa}
                />
            </div>
        )
    }
}

export default App;