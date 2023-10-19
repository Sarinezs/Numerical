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

class Secant extends Component{

    Cal_Secant(){
        
    }

    render(){
        return(
            <div>
                <div style={mainDiv}>
                    <div style={Div}>
                        <h1>Secant</h1>
                        <br/><br/>

                        <div>
                            <Form.Control id="Equation" type="text" placeholder="input Equation" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                            <br/>
                            <Form.Control id="input_x0" type="number" placeholder="input X0" style={{width:"10%", margin:"0 auto"}}></Form.Control>
                        </div>
                        <br/>

                        <Button onClick={this.Cal_Secant} style={{width:"10", margin:"0 auto"}}> Calculate </Button>
                        <br/><br/>
                        <h id="ans"></h>
                    </div>
                </div>
            </div>
        )
    }
}

export default Secant;