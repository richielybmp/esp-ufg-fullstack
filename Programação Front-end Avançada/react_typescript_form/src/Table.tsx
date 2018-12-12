import React, { Component } from 'react';
import IPessoa from "./IPessoa";

// Handler para o método de remover registro pessoa.
type RemoverPessoaHandler = (index: number) => void;

interface MyTableProps {
    pessoas: IPessoa[],
    removerPessoa: RemoverPessoaHandler,
}

// Método 'Header'
function TableHeader() {
    return (
        <thead>
            <tr>
                <th>Nome</th>
                <th>Profissão</th>
            </tr>
        </thead>
    );
}

// Método 'Body'.
// 'MyTableProps' recebida do componente pai, 'Table'.
function TableBody(props: MyTableProps) {
    const peopleData = props.pessoas.map((pessoa, i) => {
        return (
            <tr key={i}>
                <td>{pessoa.nome}</td>
                <td>{pessoa.profissao}</td>
                <td>
                    <button
                        onClick={() => props.removerPessoa(i)}>
                        Excluir
                    </button>
                </td>
            </tr>
        );
    });

    return <tbody>{peopleData}</tbody>
}

// Componente 'Table'.
// 'MyTableProps' define as propriedades que a tabela possui.
function Table(props: MyTableProps) {
    const { pessoas, removerPessoa } = props;

    return (
        <table>
            <TableHeader />
            <TableBody
                pessoas={pessoas}
                removerPessoa={removerPessoa}
            />
        </table>
    );
}

export default Table;