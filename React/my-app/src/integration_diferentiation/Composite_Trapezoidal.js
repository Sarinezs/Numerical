import {React, Component} from 'react';
import {Button, Form} from 'react-bootstrap';
import { evaluate } from 'mathjs';
import Chart from 'react-apexcharts';

const mainDiv = {
    display: "flex",
    width: "100%",
    margin: "0 auto"
}

const Div = {
    width: "100%",
    margin: "0 auto"
}

class Composite_Trapezoidal extends Component {
    constructor(props) {
        super(props);

        this.state = {
            options: {
                chart: {
                    id: "basic-bar",
                },
                xaxis: {
                    categories: [],
                },
            },
            series: [
                {
                    name: "series-1",
                    data: [],
                    
                },
            ],
        };
    }

    create_table = () => {
        var size = Number(document.getElementById("n").value);
        var a = parseFloat(document.getElementById("a").value);
        var b = parseFloat(document.getElementById("b").value);
        var data_a = [];
        var data_b = [];
        var table = "<table style='width:20%; margin-left:auto; margin-right: auto'>";

        for (var i = 0; i < size + 2; i++) {
            table += "<tr>";
            for (var j = 0; j < 2; j++) {
                table += "<td id='a" + i + j + "' style='border: 2px solid #dddddd;'></td>";
            }
        }
        table += "</table>";
        document.getElementById("t").innerHTML = table;
        document.getElementById("a" + 0 + 0).innerHTML = "x";
        document.getElementById("a" + 0 + 1).innerHTML = "fx";

        var insert_v_intable = () => {
            var fx = document.getElementById("f(x)").value;
            var h = (b - a) / size;
            data_a.push(a);
            for (var i = 1; i < size + 2; i++) {
                for (var j = 0; j < 1; j++) {
                    if (i !== 1 && j === 0) {
                        a = a + h;
                        data_a.push(a);
                    }

                    var y = evaluate(fx, { x: a });
                    data_b.push(y);
                    if (j % 2 === 0) {
                        document.getElementById("a" + i + 0).innerHTML = a.toFixed(2);
                        document.getElementById("a" + i + 1).innerHTML = y.toFixed(2);
                    } else {
                    }
                }
            }

            this.setState({
                options: {
                    ...this.state.options,
                    xaxis: {
                        categories: data_a,
                    },
                },
                series: [
                    {
                        name: "series-1",
                        data: data_b,
                    },
                ],
            });
        };

        insert_v_intable();
    };

    render() {
        return (
            <div style={mainDiv}>
                <div style={Div}>
                    <p> f(x) </p>
                    <Form.Control id="f(x)" type="text" placeholder="enter f(x)"  style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <p> a </p>
                    <Form.Control id="a" type="number" placeholder="enter a" onChange={this.handleChange} style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <p> b </p>
                    <Form.Control id="b" type="number" placeholder="enter b" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <p> n </p>
                    <Form.Control id="n" type="number" placeholder="enter n" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <Button onClick={this.create_table}> OK </Button>

                    <div id="t"></div>

                    <div style={{width:"10%",margin:"0"}}>
                        <Chart
                            options={this.state.options}
                            series={this.state.series}
                            type="line"
                            width="700"
                        />
                    </div>
                </div>
            </div>
        );
    }
}

export default Composite_Trapezoidal;
