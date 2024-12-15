import React, { useState } from 'react';
import DVDForm from './components/DVDForm';
import SearchForm from './components/SearchForm';
import DVDList from './components/DVDList';

function App() {
  const [dvdList, setDvdList] = useState([]);

  return (
    <div className="App">
      <h1>DelFlix - Gestão de DVDs</h1>
      
      <DVDForm />
      <SearchForm setDvdList={setDvdList} />
      <DVDList dvds={dvdList} />
    </div>
  );
}

export default App;
