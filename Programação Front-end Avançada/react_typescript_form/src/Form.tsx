import React, { Component } from 'react';
import IPessoa from "./IPessoa";
import TextInput from "./TextInput";

// Handler para o método de 'submit'
type SubmitPessoaHandler = (pessoa: IPessoa) => void;

interface FormProps {
    handleSubmit: SubmitPessoaHandler;
}

interface FormState {
    pessoa: IPessoa;
}

class Form extends Component<FormProps, FormState> {
    constructor(props: FormProps) {
        super(props);

        const initialState = this.initialState();

        this.state = {
            pessoa: initialState
        }
    }

    initialState() {
        return {
            nome: "",
            profissao: ""
        };
    }

    // handleNomeChange = (event: React.FormEvent<HTMLInputElement>) => {
    //     const { value } = event.currentTarget;

    //     this.setState({
    //         nome: value
    //     });
    // }

    // handleProfissaoChange = (event: React.FormEvent<HTMLInputElement>) => {
    //     const { value } = event.currentTarget;

    //     this.setState({
    //         profissao: value
    //     });

    // }

    handeInputChange = (event: React.FormEvent<HTMLInputElement>) => {
        const { value, name } = event.currentTarget;

        const oldPerson = this.state.pessoa;
        const newPerson: IPessoa = {
            ...oldPerson,
            [name]: value
          };

        this.setState({
            pessoa: newPerson
        });
    }

    submitForm = () => {
        this.props.handleSubmit(this.state.pessoa);
        this.setState({
            pessoa: this.initialState()
        });
    }

    render() {
        const { nome, profissao } = this.state.pessoa;

        return (
            <form>
                <TextInput
                    label="Nome"
                    name="nome"
                    value={nome}
                    onChange={this.handeInputChange}
                />
                <TextInput
                    label="Profissão"
                    name="profissao"
                    value={profissao}
                    onChange={this.handeInputChange}
                />
                <input
                    type="button"
                    value="Submit"
                    onClick={this.submitForm} />
            </form>
        )
    }
}

export default Form;