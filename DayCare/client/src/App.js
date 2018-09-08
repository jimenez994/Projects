import React, { Component } from 'react';
import Seconds from "./components/seconds";
import List from './components/todo/form';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Seconds />
        <List/>
      </div>
    );
  }
}

export default App;
