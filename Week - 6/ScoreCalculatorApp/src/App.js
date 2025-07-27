import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './Components/CaluculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore Name = {"Steeve"}
      School="ABC Public School"
      total ={284}
      goal = {3}
      />
    </div>
  );
}

export default App;
