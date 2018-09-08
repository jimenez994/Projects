import React, { Component } from 'react';

class Seconds extends Component {
  constructor(props){
    super(props);
    this.state = {seconds : 0}
  }
  tick() {
    this.setState(state => ({
      seconds: state.seconds+1
    }))
  }
  componentDidMount(){
    this.interval = setInterval(() => this.tick(), 1000)
  }
  componentWillUnmount(){
    clearInterval(this.interval)
  }
  
  render() {
    return (
      <div>
        <p>Seconds: {this.state.seconds}</p>
      </div>
    );
  }
}


export default Seconds;