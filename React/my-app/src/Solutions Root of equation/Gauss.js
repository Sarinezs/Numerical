import React, { Component } from "react";
import Form from "react-bootstrap/Form";

class Gauss extends Component {
  constructor() {
    super();
    console.log("constructor called");
    this.state = {
      matrixSize: 0,
      inputMatrixRendered: false,
      MatString: "",
    };
  }

  componentDidMount() {
    console.log("componentDidMount called");
  }

  createInputMatrix = () => {
    const { matrixSize } = this.state;
    const n = parseInt(matrixSize, 10);
    let inputFields = [];

    if (n > 0) {
      inputFields.push(
        <div key="matrixLabel">
          <Form.Label className="forMatrix" style={{ margin: "1% auto" }}>
            Matrix Input
          </Form.Label>
        </div>
      );

      for (let i = 0; i < n; i++) {
        let rowInputs = [];
        for (let j = 0; j < n; j++) {
          rowInputs.push(
            <input
              key={`inputA${i}${j}`}
              id={`inputA${i}${j}`}
              type="number"
              placeholder={`a${String.fromCharCode(8320 + i)}${String.fromCharCode(8321 + j)}`}
              style={{ width: "7%", margin: "0.2% auto", marginRight: "5px" }}
            />
          );
        }

        rowInputs.push(
          <span key={`separator${i}`}> | </span>
        );

        rowInputs.push(
          <input
            key={`inputB${i}`}
            id={`inputB${i}`}
            type="number"
            placeholder={`b${String.fromCharCode(8320 + i)}`}
            style={{ width: "5%", margin: "1% auto" }}
          />
        );

        inputFields.push(
          <div key={`row${i}`}>{rowInputs}</div>
        );
      }
    }

    this.setState({ inputFields, inputMatrixRendered: true });
  };


  handleMatrixSizeChange = (event) => {
    this.setState({ matrixSize: event.target.value });
  };

  confirmMatrixSize = () => {
    const { matrixSize } = this.state;
    if (matrixSize > 0) {
      this.createInputMatrix();
    } else {
      alert("Please enter a valid matrix size.");
    }
  };

  getVariable(){
    //lib
    const math = require("mathjs")

    //f
    function cloneArray(A) {
        return A.map((a)=> a.slice());
    }

    //var def
    var N = document.getElementById("matrixSize").value;
    var n = parseInt(N)
    

    //create array A
    var A = new Array(n)

    for (let index = 0; index < A.length; index++) {
        A[index] = new Array(n);
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n+1; j++) {
            var NUM = document.getElementById("inputA"+i+j+"").value;
            var num = parseInt(NUM)
            A[i][j] = num
        }
    }
    // console.log(math.sum(A))    // test

    //calculate
    var ans = '';
    var calM = cloneArray(A);
    for (let c = 0; c < n - 1; c++) {
      for (let i = c + 1; i < n; i++) {
        var toMul = calM[i][c];
        if (calM[i][c] !== 0) {
          for (var j = 0; j < n + 1; j++) {
            calM[i][j] = Number((calM[i][j] - (calM[c][j] / calM[c][c] * toMul)).toFixed(5));
          }
        }
      }
    }
    
    //solve equation
    var x = new Array(n);
    x[n - 1] = calM[n - 1][n] / calM[n - 1][n - 1];
    for (let i = n - 2; i >= 0; i--) {
      var sum = 0;
      for (let j = n - 1; j >= i + 1; j--) {
        sum += calM[i][j] * x[j];
      }
      x[i] = (calM[i][n] - sum) / calM[i][i];
    }
    for (let i = 0; i < n; i++) {
      ans += `X<sub>${i + 1}</sub> = ${x[i]}<br>`;
    }
    //sent
    document.getElementById("showAns").innerHTML = ans;
  };

  render() {
    const { inputMatrixRendered, MatString } = this.state;

    const h3Style = {
      marginTop: "20px",
    };

    return (
      <div className="text-center">
        <h3 style={h3Style}>Gauss Elimination Method</h3>
        <Form>
          <Form.Group className="mb-3 text-center">
            <Form.Label className="text-center">Input Matrix Size</Form.Label>
            <Form.Control
              id="matrixSize"
              type="number"
              placeholder="Enter matrix size n x n"
              style={{ width: "35%", margin: "1% auto" }}
              onChange={this.handleMatrixSizeChange}
            />
            <button
              type="button"
              className="btn btn btn-warning"
              style={{ margin: "1% auto" }}
              onClick={this.confirmMatrixSize}
            >
              Confirm
            </button>
          </Form.Group>
        </Form>

        {inputMatrixRendered && (
          <div className="text-center">
            <div className="secoundHead" id="generateMatrix">
              {MatString}
            </div>
            <button
              type="button"
              className="btn btn btn-warning"
              style={{ margin: "1% auto" }}
              onClick={this.getVariable}
            >
              Calculate
            </button>
            <div className="secoundHead text-center" id="showAns"></div>
          </div>
        )}
      </div>
    );
  }
}

export default Gauss;
