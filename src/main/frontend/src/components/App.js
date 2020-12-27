import { Fragment } from 'react';
import Dashboard from './Dashboard';
import Header from './Header';

import { Provider } from 'react-redux';
import store from '../store';
import Products from './Products';

function App() {
  return (
    <Provider store={store}>
      <Fragment>
        <Header />
        <div className="container-fluid">
          <Dashboard />
          <Products />
        </div>
      </Fragment>
    </Provider>
  );
}

export default App;
