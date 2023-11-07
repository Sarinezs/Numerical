import {React, Component, useState} from 'react';
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

class Composite_Trapezoidal extends Component{   
    

    create_table(){
        var size = Number(document.getElementById("n").value);
        var table = "<table style='width:20%; margin-left:auto; margin-right: auto'>";
        var a = parseFloat(document.getElementById("a").value);
        var b = parseFloat(document.getElementById("b").value);
        // const [testa, settesta] = useState(0);
        

        for(var i = 0; i<size+2; i++){
            table += "<tr>"
            for(var j = 0; j<2; j++){
                table += "<td id='a"+i+j+"' style='border: 2px solid #dddddd;'></td>"
            }
        }
        table += "</table>";
        document.getElementById("t").innerHTML=table;
        document.getElementById("a"+0+0).innerHTML="x";
        document.getElementById("a"+0+1).innerHTML="fx";
        
        var insert_v_intable = () =>{
            var fx = document.getElementById("f(x)").value;
            var h = (b-a)/size;
            for(var i = 1; i<size+2; i++){
                for(var j = 0; j<2; j++){
                    
                    if(i !== 1 && j === 0){
                        a = a+h;
                    }
                    
                    var y = (evaluate(fx, {x:a}));
                    if(j % 2 ===0){
                        document.getElementById("a"+i+j).innerHTML=a.toFixed(2);
                    }
                    else{
                        document.getElementById("a"+i+j).innerHTML=y.toFixed(2);
                    }
                }
            }
        }
        insert_v_intable();

        

    }

    

    render(){
        return(
            <div style={mainDiv}>
                <div style={Div}>
                    <p> f(x) </p>
                    <Form.Control id="f(x)" type="text" placeholder="enter f(x)" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <p> a </p>
                    <Form.Control id="a" type="number" placeholder="enter a" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <p> b </p>
                    <Form.Control id="b" type="number" placeholder="enter b" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <p> n </p>
                    <Form.Control id="n" type="number" placeholder="enter n" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                    <br/>

                    <Button onClick={this.create_table}> OK </Button>


                    <div id='t'>

                    </div>


                    <div>
                    </div>

                </div>
            </div>
        )
    }

}

export default Composite_Trapezoidal;