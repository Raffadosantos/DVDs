import React, { useState } from 'react';
import axios from 'axios';

function SearchForm({ setDvdList }) {
  const [title, setTitle] = useState('');
  const [genre, setGenre] = useState('');
  const [directorName, setDirectorName] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get('http://localhost:8080/api/dvds', {
        params: {
          title,
          genre,
          directorName,
        },
      });
      setDvdList(response.data);
    } catch (error) {
      console.error('Erro ao pesquisar DVDs:', error);
      alert('Erro ao pesquisar DVDs.');
    }
  };

  return (
    <form onSubmit={handleSearch}>
      <h2>Pesquisar DVDs</h2>
      <div>
        <label>Título:</label>
        <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
      </div>
      <div>
        <label>Gênero:</label>
        <input type="text" value={genre} onChange={(e) => setGenre(e.target.value)} />
      </div>
      <div>
        <label>Nome do Diretor:</label>
        <input type="text" value={directorName} onChange={(e) => setDirectorName(e.target.value)} />
      </div>
      <button type="submit">Pesquisar</button>
    </form>
  );
}

export default SearchForm;
