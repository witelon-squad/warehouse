import { Fragment } from 'react';
import Header from './Header';

import { Provider } from 'react-redux';
import store from '../store';
import Products from './Products';
import AddProduct from './AddProduct';
import ProductDetails from './ProductDetails';
import Alerts from './Alerts';

import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import { Provider as AlertProvider } from 'react-alert';
import AlertTemplate from 'react-alert-template-basic';

const alertSettings = {
  timeout: 3000,
  position: 'top center'
};

function App() {
  
  return (
    <Provider store={store}>
      <AlertProvider template={AlertTemplate} {...alertSettings}>
        <Router>
          <Fragment>
            <Header />
            <Alerts />
            <div className='container-fluid p-0'>
              <Switch>
                <Route exact path='/add'>
                  <AddProduct />
                </Route>
                <Route exact path='/products'>
                  <Products />
                </Route>
                <Route exact path='/products/:id' render={(props) => <ProductDetails {...props} />} />
              </Switch>
            </div>
          </Fragment>
        </Router>
      </AlertProvider>
    </Provider>
  );
}

export default App;
