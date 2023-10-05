import { NavBar } from './NavBar';
import './App.css';
import { BrowserRouter,Routes,Route } from 'react-router-dom';

import Newton from './Interpolation/Newton';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <NavBar/>
      <Routes>
      
        <Route path='/Newton' element={<Newton/>}/>
        
      </Routes>
      </BrowserRouter>
      
    </div>
  );
}

export default App;
