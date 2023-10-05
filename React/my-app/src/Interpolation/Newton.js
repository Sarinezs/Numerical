import {React,Component,useState} from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";


const mainDiv = {
    display:"flex",
    width:"100%",
    margin:"0 auto"
}

const Div = {
    width:"100%",
    margin:"0 auto"
}

class Newton extends Component{
    constructor(){
        super();
        // this.x = [0,20000,40000,60000,80000] ;
        // this.y = [9.8100,9.7487,9.6879,9.6879,9.5682] ;
        // this.arr_c = [];
        // this.save_c(start, end);
        // this.xvalue = 42235;
        // this.solution = 0;
        // this.term = 1;
        // this.Cal_interpolate();
    }

    // interpolate(start, end){
    //     if((end - start) == 1){
    //         return (this.y[end] - this.y[start]) / (this.x[end] - this.x[start]);
    //     }
    //     else if(end == start){
    //         return this.y[end];
    //     }
    //     else{
    //         return (this.interpolate(start+1, end) - this.interpolate(start, end-1)) / (this.x[end] - this.x[start]);
    //     }
    // }

    // save_c(start, end){
    //     for(let i = start; i<=end; i++){
    //         this.arr_c[i] = this.interpolate(start, i);
    //     }
    // }

    Cal_interpolate(){
        var x =[0,20000,40000,60000,80000];
        var y = [9.8100,9.7487,9.6879,9.6879,9.5682] ;
        var arr_c = [];
        const xvalue = 42235;
        var solution = 0;
        var term = 1;
        var start = document.getElementById("Inputstart").value;
        var end = document.getElementById("Inputend").value;

        var s = Number(start);
        var e = Number(end);

        var sum = s + e;


        const interpolate = (start, end) =>{
            if((end - start) == 1){
                return (y[end] - y[start]) / (x[end] - x[start]);
            }
            else if(end == start){
                return y[end];
            }
            else{
                return (interpolate(start+1, end) - interpolate(start, end-1)) / (x[end] - x[start]);
            }
        }

        
        const save_c = (start,end) =>{
            

            for(let i = start; i<=end; i++){
                arr_c[i] = interpolate(start, i);
            }
        };
        
        save_c(s,e);

        document.getElementById("ShowM").innerHTML=start;
        document.getElementById("ShowC").innerHTML=end;
       

        for(let i = 0; i<arr_c.length; i++){
            if(i == 0){
                solution += arr_c[i];
            }
            else{
                term *= (xvalue - x[i-1]);
                solution += arr_c[i]*term;
            }
        }

        document.getElementById("Showm").innerHTML=solution;

    }

    render(){
        return(
            <div>
               <div style={mainDiv}>
                   <div  style={Div} >
                        <h1> Newton Interpolation </h1>
                        <br></br>

                            <div>
                                <Form.Control id="Inputstart" type="number" placeholder="input start" style={{width:"20%",margin:"0 auto"}}></Form.Control>
                                <br></br>
                                <Form.Control id="Inputend" type="number" placeholder="input end" style={{width:"20%",margin:"0 auto"}}></Form.Control>
                            </div>
                            <br>
                            </br>

                            <Button onClick={this.Cal_interpolate}  style={{width:"10%",margin:"0 auto"}} >
                                    Enter
                            </Button>
                    
                            <br></br><br></br><br></br>
                            <div style={{width:"40%",height:"5%",margin:"0 auto",background:'#F0FFF0'}}>
                            <h>ANS = </h>
                            <h style={{color:'green'}} id="Showm">  </h>

                            <br></br><br></br><br></br>
                            <div style={{width:"40%",margin:"0 auto",background:'#FFFFE0',textAlign:"center"}}>
                                <h4>check value </h4>
                                <div style={{width:"40%",margin:"0 auto",textAlign:"left"}}>
                                    <h>start = </h>
                                    <h id="ShowM"></h><br></br>
                                    <h>end = </h>
                                    <h id="ShowC"></h>
                                </div>
                            </div>

                        </div>
                        

                    </div>
                </div>
            </div>
            
        );
    }

}

export default Newton;