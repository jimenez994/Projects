import React, { Component } from 'react';
import List from './list';

class Form extends Component {
  constructor(props) {
    super(props);
    this.state = { 
      items: [], 
      task:"",
      description:""
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit(event){
    this.setState({items: [...this.state.items, this.state.task ]})
    this.setState({task: ""})
    event.preventDefault();
  }
  handleChange(event){
    this.setState({[event.target.name] : event.target.value})
  }
  render() {
    return (
      <div>
        <List items={ this.state.items }/>
        <form onSubmit={this.handleSubmit}>
          <input type="text" name="task" onChange={this.handleChange} value={this.state.task} /><br/>
          <button>Submit</button>
        </form>
      </div>
    );
  }
}

export default Form;