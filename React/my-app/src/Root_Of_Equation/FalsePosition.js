import {React, Component} from"react";
import {Button, Form} from"react-bootstrap";
import {evaluate} from"mathjs";

const mainDiv = {
    display:"flex",
    width:"100%",
    margin:"0 auto"
}

const Div = {
    width:"100%",
    margin:"0 auto"
}

class FalsePosition extends Component{


    

    Cal_Falseposition(){
        var XR = Number(document.getElementById("input_xr").value);
        var XL = Number(document.getElementById("input_xl").value);
        var equation = document.getElementById("Equation").value;
        var xr = parseFloat(XR);
        var xl = parseFloat(XL);
        var scope;
        var xm, yl, yr, ym;
    
        do{
            scope = { x:xr };
            yr = evaluate(equation, scope);
            scope = { x:xl };
            yl = evaluate(equation, scope);
            xm = (xl*yr - xr*yl) / (yr - yl);
            scope = { x:xm };
            ym = evaluate(equation, scope);

            if(ym * yr < 0){
                xl = xm;
            }
            else if(ym * yr > 0){
                xr = xm;
            }
        }
        while(Math.abs(ym) >= 0.000001);

        document.getElementById("ans").innerHTML=xm;
    }

    render(){
        return(
            <div>
                <div style={mainDiv}>
                    <div style={Div}>
                        <h1>FalsePosition</h1>
                        <br/><br/>

                        <div>
                            <Form.Control id="Equation" type="text" placeholder="input Equation" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                            <br/>
                            <Form.Control id="input_xl" type="number" placeholder="input XL" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                            <Form.Control id="input_xr" type="number" placeholder="input XR" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                        </div>
                        <br/>

                        <Button onClick={this.Cal_Falseposition} style={{width:"10", margin:"0 auto"}}> Calculate </Button>
                        <br/><br/>
                        <h id="ans"></h>
                    </div>
                </div>
            </div>
        )
    }
}

export default FalsePosition;