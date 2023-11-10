import {React, Component, useState} from'react';
import {Button, Form} from 'react-bootstrap';
import {evaluate} from 'mathjs';
import Chart from 'react-apexcharts';

const mainDiv = {
    display:"flex",
    width:"100%",
    margin:"0 auto"
}

const Div = {
    width:"100%",
    margin:"0 auto"
}

class Composite_Trapezoidal extends Component{
    constructor(props){
        super(props);
        this.state = {
            option:{
                chart:{
                    id: "basic-bar",
                },
                xaxis:{
                    categories: [],
                },
            },
            series:[
                {
                    name:"series-1",
                    data: [],
                },
            ],
        };
    }

    

    render(){
        return(
            <div style={mainDiv}>
                <div style={Div}>
                    <p> f(x)</p>
                    <Form.Control id='f(x)' type="text" placeholder='enter'></Form.Control>
                </div>
            </div>
        )
    }
}