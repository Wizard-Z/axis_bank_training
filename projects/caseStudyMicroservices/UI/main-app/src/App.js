import {Route, Switch} from 'react-router-dom'
import Home from './pages/Home'
import Rooms from './pages/Rooms'
import SingleRoom from './pages/SingleRoom'
import Error from './pages/Error'
import Navbar from './components/Navbar'
import './App.css';
import Checkout from './pages/Checkout'
import Success from './pages/Success'
import testKafka from './pages/test-kafka'

/*
* Context for
*/

function App() {
  return (
    <div>
     <Navbar/>
      <Switch>
      <Route exact path="/" component={Home}/>
      <Route exact path="/rooms" component={Rooms}/>
      <Route exact path ="/room/:type" component={SingleRoom}/>
      <Route exact path = "/test/checkout/:room" component={Checkout}/> 
      <Route exact path = "/test/checkout/:room/success" component={Success}/> 
      <Route exact path = "/test/kafka" component={testKafka}/> 
      <Route component={Error}/>
      </Switch>

    </div>
  );
}

export default App;
