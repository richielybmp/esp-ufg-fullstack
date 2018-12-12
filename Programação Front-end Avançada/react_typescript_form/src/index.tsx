import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import App from "./App";

const app = <App />
const element = document.querySelector('#root')

ReactDOM.render(app, element);

