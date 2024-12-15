import React, { useState } from 'react';
import axios from 'axios';

function DVDForm() {
  const [title, setTitle] = useState('');
  const [genre, setGenre] = useState('');
  const [year, setYear] = useState('');
  const [directorName, setDirectorName] = useState('');
  const [directorSurname, setDirectorSurname] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/api/dvds', null, {
        params: {
          title,
          genre,
          year,
          directorName,
          directorSurname,
        },
      });
      alert('DVD cadastrado com sucesso!');
    } catch (error) {
      console.error('Erro ao cadastrar DVD:', error);
      alert('Erro ao cadastrar DVD.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Cadastrar DVD</h2>
      <div>
        <label>Título:</label>
        <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} required />
      </div>
      <div>
        <label>Gênero:</label>
        <input type="text" value={genre} onChange={(e) => setGenre(e.target.value)} required />
      </div>
      <div>
        <label>Ano:</label>
        <input type="number" value={year} onChange={(e) => setYear(e.target.value)} required />
      </div>
      <div>
        <label>Nome do Diretor:</label>
        <input type="text" value={directorName} onChange={(e) => setDirectorName(e.target.value)} required />
      </div>
      <div>
        <label>Sobrenome do Diretor:</label>
        <input type="text" value={directorSurname} onChange={(e) => setDirectorSurname(e.target.value)} required />
      </div>
      <button type="submit">Cadastrar</button>
    </form>
  );
}

export default DVDForm;
