import React, { Component } from 'react';

type TextChangedHandler = (event: React.FormEvent<HTMLInputElement>) => void

interface TextInputProps {
    label: string;
    name: string;
    value?: string;
    onChange?: TextChangedHandler;
}

function TextInput(props: TextInputProps) {
    function handleChange(e: React.FormEvent<HTMLInputElement>){
        const onChange = props.onChange; 

        if (onChange){
            onChange(e);
        }
    }

    return (
        <div className="field">
            <label> {props.label}:</label>
            <input
                type="text"
                name={props.name}
                value={props.value}
                onChange={handleChange}
            />
        </div>
    );
}

export default TextInput;