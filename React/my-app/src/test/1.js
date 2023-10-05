import logo from './logo.svg';
import './App.css';
import Lagange_Interpolation from './class_Interpolation' ;


function App() {
  const x_fx = new Lagange_Interpolation([0,4]) ;
  const x_fx1 = new Lagange_Interpolation([0,2,4]) ;
  const x_fx2 = new Lagange_Interpolation([0,1,2,3,4]) ;
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <p>
        <ul>
        {x_fx.array_fx.map((fx,number) => (
          <li><p>fx{number} = {fx} x{number} = {x_fx.array_x[number]}</p></li>
        ))}
        </ul>
        
        </p>
        <a
          className="interpolation"
          href="interpolation.html"
          target="_blank"
          rel="noopener noreferrer"
        >
          Interpolation
        </a>
      </header>
      <div className='App-bodier'>
      <p>
      <ul>
        {x_fx.L.map((L,number) => (
          <li><p>L{number} = {L} </p></li>
        ))}
      </ul>
      {x_fx.myfx}
      </p>
      </div>
      <div className='App-bodier'>
      <p>
      <ul>
        {x_fx1.L.map((L,number) => (
          <li><p>L{number} = {L} </p></li>
        ))}
      </ul>
      {x_fx1.myfx}
      </p>
      </div>
      <div className='App-bodier'>
      <p>
      <ul>
        {x_fx2.L.map((L,number) => (
          <li><p>L{number} = {L} </p></li>
        ))}
      </ul>
      {x_fx2.myfx}
      </p>
      </div>
    </div>
    
  );
}


export default App;
