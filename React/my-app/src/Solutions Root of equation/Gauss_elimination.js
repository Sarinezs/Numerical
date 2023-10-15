import {React,Component} from "react";
import {Button} from "react-bootstrap";
import {Form} from "react-bootstrap";

const mainDiv = {
    display: "flex",
    width:"100%",
    margin:"0 auto"
}

const Div = {
    width:"100%",
    margin:"0 auto"
}

class Gauss_elimination extends Component{

    create_matrix_input(){
        var size = document.getElementById("size_of_matrix").value;
        var m_input = "";

        for(var i = 0; i<size; i++){
            for(var j = 0; j<size; j++){
                m_input += "<input id='input"+i+j+"' type='number' placeholder='a"+(i+1)+(j+1)+" ' style='width:50px;margin:5px;' >"
            }
            m_input += "<input id='inputans"+i+"0' type='number' placeholder='b"+(i+1)+"' style='width:50px;margin-left:20px;' ><br/>";
        }
        document.getElementById("matrix_table").innerHTML=m_input;
    }

    Cal_Gauss = () =>{
        var size = document.getElementById("size_of_matrix").value;
        var a = [];
        var b = [];
        var solution = [];

        for(let i = 0; i<size; i++){
            a.push([]);
            for(let j = 0; j<size; j++){
                a[i].push(document.getElementById("input"+i+j).value);
            }     
            b.push([]);   
            b[i].push(document.getElementById("inputans"+i+0).value);    
        }



        var echelonform = () =>{
            for(var k = 0; k<size; k++){
                for(var i = k+1; i<size; i++){
                    var factor = a[i][k] / a[k][k];
                    b[i] -= (factor * b[k]).toFixed(2);
                    for(var j = k; j<size; j++){
                        a[i][j] -= (factor * a[k][j]).toFixed(2);
                    }
                    printform();
                }
            }

            for(var i = size-1; i>=0; i--){
                var sum = 0;
                for(var j = i+1; j<size; j++){
                    sum += a[i][j] * solution[j];
                }
                solution[i] = ((b[i] - sum) / a[i][i]).toFixed(2);
            }
        }

        var printform = () =>{
            var table = "<table style='width:20%; margin-left:auto; margin-right: auto'>";
            // <tr><td style='border: 2px solid #dddddd;'>a</td><td style='border: 2px solid #dddddd;'> B </td><td style='border: 2px solid #dddddd; margin-left: 20px'> y </td></table>";
            for(var i = 0; i<size; i++){
                table += "<tr>";
                for(var j = 0; j<size; j++){
                    
                    table += "<td id='a"+i+j+"' style='border: 2px solid #dddddd;'></td>"
                }
                table += "<td id='b"+i+"0' style='border: 2px solid #dddddd;margin-left: 20px'></td></tr>"
            }
            table += "</table>";
            document.getElementById("matrix_b2").innerHTML=table;

            for(var i = 0; i<size; i++){
                for(var j = 0; j<size; j++){
                    document.getElementById("a"+i+j).innerHTML=a[i][j];
                }
                document.getElementById("b"+i+0).innerHTML=b[i];
            }

        }

        echelonform();
        
    }


    render(){
        return(
            <div>
                <div style={mainDiv}>
                    <div style={Div}>
                        <h1>Gauss_elimination</h1>
                        <br/>
                        <div>
                            <Form.Control id="size_of_matrix" placeholder="enter matrix size" type="number" step="1"></Form.Control>
                        </div>
                        <br/><br/>
                        <Button onClick={this.create_matrix_input}>
                            OK
                        </Button>

                        <br/><br/><br/>

                        <div id="matrix_table">

                        </div>
                        <br/>

                        <Button onClick={this.Cal_Gauss}>
                            submit
                        </Button>
                    
                        <br/><br/>

                        <div id="matrix_a">

                        </div>
                        <br/><br/>

                        <div id="matrix_b"></div>
                        <br/>
                        <div id="matrix_b1"></div>
                        <br/>
                        <div id="matrix_b2">
                            {/* <table style={{width: "20%", marginLeft: "auto", marginRight: "auto" } }>
                                <tr>
                                    <td style={{border: "2px solid #dddddd"}}>x1</td>
                                    <td style={{border: "2px solid #dddddd"}}>x2</td>
                                    <td style={{border: "2px solid #dddddd"}}>x3</td>
                                    <td style={{border: "2px solid #dddddd"}}>y</td>
                                </tr>
                                <tr>
                                    <td style={{border: "2px solid #dddddd"}}>3</td>
                                    <td style={{border: "2px solid #dddddd"}}>2</td>
                                    <td style={{border: "2px solid #dddddd"}}>0</td>
                                    <td style={{border: "2px solid #dddddd"}}>9</td>
                                </tr>
                            </table> */}
                        </div>
                        <br/>


                    </div>
                </div>
            </div>
        );
    }
}

export default Gauss_elimination;