import React, { Component } from 'react';
import Item from './item';

class List extends Component {
  
  render() {
    return (
      <div>
        {this.props.items.map((item) => 
          <Item key={item} item={item}/>
        )}
      </div>
    );
  }
}

export default List;