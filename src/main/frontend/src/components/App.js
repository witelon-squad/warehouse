import { Fragment } from 'react';
import Dashboard from './Dashboard';
import Header from './Header';

import { Provider } from 'react-redux';
import store from '../store';
import Products from './Products';
import AddProduct from './AddProduct';

function App() {
  return (
    <Provider store={store}>
      <Fragment>
        <Header />
        <div className="container">
          <AddProduct />
          <Products />
        </div>
      </Fragment>
    </Provider>
  );
}

export default App;
