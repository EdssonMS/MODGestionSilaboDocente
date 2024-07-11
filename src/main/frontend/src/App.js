import logo from './logo.svg';
import './App.css';
import Sidebar from './components/Sidebar';
import HeaderComponent from './components/HeaderComponent';
import ListSilabosComponent from './components/ListSilabosComponent';
import AddSilaboForm from './components/AddSilaboForm'
import AddSilaboComponent from './components/AddSilaboComponent';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { AddSilaboFormProvider } from './context/AddSilaboFormContext';
import ListUnidadesComponent from './components/ListUnidadesComponent';
import AddGrupoComponent from './components/AddGrupoComponent';
import { DownloadSilaboComponent } from './components/DownloadSilaboComponent';

function App() {
  return (
    <div className='app-container'>
      <BrowserRouter>
        <Sidebar/>
        <div className='main-content'>
          <HeaderComponent/>
          <Routes>
            <Route exact path='/' element = {<ListSilabosComponent/>}></Route>
            <Route exact path='/silabos' element = {<ListSilabosComponent/>}></Route>
            <Route exact path='/add-silabo' element = {<AddSilaboFormProvider>
              <AddSilaboForm />
            </AddSilaboFormProvider>}></Route>
            <Route exact path='/edit-silabo/:id' element = {<AddSilaboFormProvider>
              <AddSilaboForm />
            </AddSilaboFormProvider>}></Route>
            <Route exact path='/unidades' element = {<ListUnidadesComponent/>}></Route>
            <Route exact path='/add-grupo' element = {<AddGrupoComponent/>}></Route>
            <Route exact path='/edit-grupo/:id' element = {<AddGrupoComponent/>}></Route>

            <Route exact path='/download-silabo/:id' element = {<DownloadSilaboComponent/>}></Route> 
            
            {/*<AddSilaboComponent/>*/}
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
