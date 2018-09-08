import React, { Component } from 'react';

class List extends Component {
  
  render() {
    return (
      <div>
        <p>This is a item {this.props.items.map((item) =>  
          <li key={item} >{item}</li>
        )}</p>
      </div>
    );
  }
}

export default List;