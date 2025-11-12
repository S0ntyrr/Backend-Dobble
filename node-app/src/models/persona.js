module.exports = (sequelize, DataTypes) => {
  const Persona = sequelize.define('Persona', {
    id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
    nombre: { type: DataTypes.STRING },
    email: { type: DataTypes.STRING },
    telefono: { type: DataTypes.STRING }
  }, { tableName: 'persona', timestamps: false });
  return Persona;
};
