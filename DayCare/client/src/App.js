import React, { Component } from 'react';
import Seconds from "./views/seconds";
import List from './views/todo/form';
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
