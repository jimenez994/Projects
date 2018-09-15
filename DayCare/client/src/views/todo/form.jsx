import React, { Component } from 'react';
import List from './list';
import GridContainer from "../../components/Grid/GridContainer"
import Card from '@material-ui/core/Card'
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button"

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
    return <div>
        <GridContainer justify="center">
          <Card  color="rose">
            <form onSubmit={this.handleSubmit}>
              <input type="text" name="task" onChange={this.handleChange} value={this.state.task} />
              <br />
              <Button color="primary" size="small">Submit </Button>
            </form>
            <CardContent color="primary ">
              <List items={this.state.items} />
            </CardContent>
          </Card>
        </GridContainer>
      </div>;
  }
}

export default Form;