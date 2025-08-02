import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };

    this.handleDecrement = this.handleDecrement.bind(this);
  }

  handleIncrement = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  sayHello = () => {
    console.log("Hello! This is a static message.");
  };

  handleDecrement() {
    this.setState({ count: this.state.count - 1 });
  }

  sayWelcome(message) {
    alert("Message: " + message);
  }

  handleClick = (e) => {
    console.log("I was clicked");
    console.log("Synthetic Event:", e);
  };

  render() {
    return (
      <div>
        <h2>Counter Value: {this.state.count}</h2>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>
        <br /><br />
        <button onClick={() => this.sayWelcome("Welcome")}>Say Welcome</button>
        <br /><br />
        <button onClick={this.handleClick}>Synthetic OnPress</button>
      </div>
    );
  }
}

export default Counter;
