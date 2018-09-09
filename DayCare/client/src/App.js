import React, { Component } from 'react';
import Seconds from "./components/seconds";
import List from './components/todo/form';
import Navbar from './components/navbarc';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Navbar/>
        <Seconds />
        <List/>
      </div>
    );
  }
}

export default App;
