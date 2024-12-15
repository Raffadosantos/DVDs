import React from 'react';

function DVDList({ dvds }) {
  return (
    <div>
      <h2>Lista de DVDs</h2>
      {dvds.map((dvd, index) => (
        <div key={index}>
          <p><strong>{dvd.title}</strong> - {dvd.genre} - {dvd.director.name} {dvd.director.surname} ({dvd.year})</p>
        </div>
      ))}
    </div>
  );
}

export default DVDList;
